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

import com.tang.intellij.devkt.lua.comment.lexer.LuaDocLexerAdapter;
import com.tang.intellij.devkt.lua.comment.parser.LuaDocParser;
import com.tang.intellij.devkt.lua.comment.psi.impl.LuaCommentImpl;
import com.tang.intellij.devkt.lua.lang.LuaLanguage;
import com.tang.intellij.devkt.lua.lexer.LuaLexer;
import com.tang.intellij.devkt.lua.parser.LuaParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.lang.PsiBuilder;
import org.jetbrains.kotlin.com.intellij.lang.PsiBuilderFactory;
import org.jetbrains.kotlin.com.intellij.lang.PsiParser;
import org.jetbrains.kotlin.com.intellij.openapi.project.Project;
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType;
import org.jetbrains.kotlin.com.intellij.psi.tree.ILazyParseableElementType;
import org.jetbrains.kotlin.com.intellij.psi.tree.IReparseableElementType;

/**
 * Created by TangZhiXu on 2015/11/15.
 * Email:272669294@qq.com
 */
public class LuaElementType extends IElementType {
	public static ILazyParseableElementType DOC_COMMENT = new ILazyParseableElementType("DOC_COMMENT",
			LuaLanguage.INSTANCE) {

		@Override
		public ASTNode parseContents(ASTNode chameleon) {
			Project project = chameleon.getPsi().getProject();
			PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project,
					chameleon,
					new LuaDocLexerAdapter(),
					LuaLanguage.INSTANCE,
					chameleon.getChars());
			PsiParser parser = new LuaDocParser();
			ASTNode node = parser.parse(this, builder);
			return node.getFirstChildNode();
		}

		@NotNull
		@Override
		public ASTNode createNode(CharSequence text) {
			return new LuaCommentImpl(text);
		}
	};
	public static IElementType FUNC_DEF = new LuaElementType("FUNC_DEF");
	public static IElementType CLASS_METHOD_DEF = new LuaElementType("CLASS_METHOD_DEF");
	public static IElementType CLASS_FIELD_DEF = new LuaElementType("CLASS_FIELD_DEF");
	public static IElementType TYPE_DEF = new LuaElementType("TYPE_DEF");
	public static IElementType CLASS_DEF = new LuaElementType("CLASS_DEF");
	public static IElementType DOC_TABLE_DEF = new LuaElementType("DOC_TABLE_DEF");
	public static IElementType DOC_TABLE_FIELD_DEF = new LuaElementType("DOC_TABLE_FIELD_DEF");
	public static IElementType TABLE_FIELD = new LuaElementType("TABLE_FIELD");
	public static IElementType NAME_EXPR = new LuaElementType("NAME_EXPR");
	public static IElementType TABLE = new LuaElementType("TABLE");
	public static IElementType INDEX = new LuaElementType("INDEX");
	public static ILazyParseableElementType BLOCK = new LuaBlockElementType();
	public static IElementType NAME_DEF = new LuaElementType("NAME_DEF");
	public static IElementType PARAM_NAME_DEF = new LuaElementType("PARAM_NAME_DEF");
	public static IElementType LITERAL_EXPR = new LuaElementType("LITERAL_EXPR");
	public LuaElementType(String debugName) {
		super(debugName, LuaLanguage.INSTANCE);
	}

	static class LuaBlockElementType extends IReparseableElementType {

		LuaBlockElementType() {
			super("LuaBlock", LuaLanguage.INSTANCE);
		}

		@Override
		public ASTNode parseContents(@NotNull ASTNode chameleon) {
			Project project = chameleon.getPsi().getProject();
			PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project,
					chameleon,
					new LuaLexer(),
					LuaLanguage.INSTANCE,
					chameleon.getText());
			PsiParser luaParser = new LuaParser();
			return luaParser.parse(this, builder).getFirstChildNode();
		}

		@Nullable
		@Override
		public ASTNode createNode(CharSequence text) {
			return null;
		}
	}
}
