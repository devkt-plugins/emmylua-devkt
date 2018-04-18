/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.devkt.lua.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.psi.PsiComment;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiFile;
import org.jetbrains.kotlin.com.intellij.psi.PsiWhiteSpace;
import org.jetbrains.kotlin.com.intellij.psi.search.PsiElementProcessor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.kotlin.com.intellij.util.Processor;

/**
 * Created by tangzx on 2016/12/3.
 */
public class LuaPsiTreeUtil {

	private static final Class[] WS = {PsiWhiteSpace.class};
	private static final Class[] WS_COMMENTS = {PsiWhiteSpace.class, PsiComment.class};

	public static void walkUpLabel(PsiElement current, Processor<LuaLabelStat> processor) {
		PsiElement prev = current.getPrevSibling();
		while (true) {
			if (prev == null) prev = current.getParent();
			if (prev == null || prev instanceof PsiFile) break;
			if (prev instanceof LuaLabelStat && !processor.process((LuaLabelStat) prev)) break;
			current = prev;
			prev = prev.getPrevSibling();
		}
	}

	public static <T extends PsiElement> void walkTopLevelInFile(PsiElement element, Class<T> cls, Processor<T> processor) {
		if (element == null || processor == null) return;
		PsiElement parent = element;
		while (!(parent.getParent() instanceof PsiFile)) parent = parent.getParent();

		for (PsiElement child = parent; child != null; child = child.getPrevSibling()) {
			if (cls.isInstance(child)) {
				if (!processor.process(cls.cast(child))) {
					break;
				}
			}
		}
	}

	@Nullable
	public static <T extends PsiElement> T findElementOfClassAtOffset(@NotNull PsiFile file, int offset, @NotNull Class<T> clazz, boolean strictStart) {
		T t = PsiTreeUtil.findElementOfClassAtOffset(file, offset, clazz, strictStart);
		if (t == null) t = PsiTreeUtil.findElementOfClassAtOffset(file, offset - 1, clazz, strictStart);
		return t;
	}

	public static <T extends PsiElement> T getParentOfType(@Nullable PsiElement element, @NotNull Class<T> aClass, @NotNull Class... skips) {
		if (element == null) {
			return null;
		} else {
			element = element.getParent();

			while (element != null && !aClass.isInstance(element) && PsiTreeUtil.instanceOf(element, skips)) {
				if (element instanceof PsiFile) {
					return null;
				}

				element = element.getParent();
			}

			return aClass.cast(element);
		}
	}

	public static PsiElement skipWhitespacesBackward(@Nullable PsiElement element) {
		return PsiTreeUtil.skipSiblingsBackward(element, WS);
	}

	public static PsiElement skipWhitespacesAndCommentsBackward(@Nullable PsiElement element) {
		return PsiTreeUtil.skipSiblingsBackward(element, WS_COMMENTS);
	}

	public static PsiElement skipWhitespacesForward(@Nullable PsiElement element) {
		return PsiTreeUtil.skipSiblingsForward(element, WS);
	}

	public static PsiElement skipWhitespacesAndCommentsForward(@Nullable PsiElement element) {
		return PsiTreeUtil.skipSiblingsForward(element, WS_COMMENTS);
	}

	public static void processChildren(PsiElement parent, PsiElementProcessor<PsiElement> processor) {
		PsiElement child = parent.getFirstChild();
		while (child != null) {
			if (processor.execute(child)) {
				child = child.getNextSibling();
			} else break;
		}
	}
}
