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

package com.tang.intellij.devkt.lua.comment.psi.impl

import com.tang.intellij.devkt.lua.comment.LuaCommentUtil
import com.tang.intellij.devkt.lua.comment.psi.*
import com.tang.intellij.devkt.lua.comment.psi.api.LuaComment
import com.tang.intellij.devkt.lua.psi.LuaCommentOwner
import com.tang.intellij.devkt.lua.psi.LuaTypes
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LazyParseablePsiElement
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil

/**
 * Created by Tangzx on 2016/11/21.
 *
 */
class LuaCommentImpl(charSequence: CharSequence?) : LazyParseablePsiElement(LuaTypes.DOC_COMMENT, charSequence), LuaComment {
	override fun <T : LuaDocPsiElement> findTag(t: Class<T>): T? {
		var element: PsiElement? = firstChild
		while (element != null) {
			if (t.isInstance(element)) {
				return t.cast(element)
			}
			element = element.nextSibling
		}
		return null
	}

	override fun <T : LuaDocPsiElement> findTags(t: Class<T>): Collection<T> {
		return PsiTreeUtil.findChildrenOfType(this, t)
	}

	override fun getTokenType(): IElementType {
		return LuaTypes.DOC_COMMENT
	}

	override val owner: LuaCommentOwner?
		get() = LuaCommentUtil.findOwner(this)

	override val moduleName: String?
		get() = null

	override fun getParamDef(name: String): LuaDocParamDef? {
		var element: PsiElement? = firstChild
		while (element != null) {
			if (element is LuaDocParamDef) {
				val nameRef = element.paramNameRef
				if (nameRef != null && nameRef.text == name)
					return element
			}
			element = element.nextSibling
		}
		return null
	}

	override fun getFieldDef(name: String): LuaDocFieldDef? {
		return null
	}

	override val classDef: LuaDocClassDef?
		get() {
			var element: PsiElement? = firstChild
			while (element != null) {
				if (element is LuaDocClassDef) {
					return element
				}
				element = element.nextSibling
			}
			return null
		}

	override val returnDef: LuaDocReturnDef?
		get() {
			var element: PsiElement? = firstChild
			while (element != null) {
				if (element is LuaDocReturnDef) {
					return element
				}
				element = element.nextSibling
			}
			return null
		}

	override val typeDef: LuaDocTypeDef?
		get() {
			var element: PsiElement? = firstChild
			while (element != null) {
				if (element is LuaDocTypeDef) {
					return element
				}
				element = element.nextSibling
			}
			return null
		}

	override fun isOverride(): Boolean {
		var elem = firstChild
		while (elem != null) {
			if (elem is LuaDocTagDef) {
				if (elem.text == "override") return true
			}
			elem = elem.nextSibling
		}
		return false
	}

	override fun toString(): String {
		return "DOC_COMMENT"
	}
}
