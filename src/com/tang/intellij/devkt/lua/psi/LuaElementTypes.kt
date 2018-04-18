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

package com.tang.intellij.devkt.lua.psi

import com.tang.intellij.devkt.lua.psi.impl.*
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.PsiElement

class LuaPlaceholderStub {
	class Type(debugName: String, `class`: (ASTNode) -> PsiElement) : LuaElementType(debugName)
}

object LuaElementTypes {

	val LOCAL_DEF = LuaPlaceholderStub.Type("LOCAL_DEF", ::LuaLocalDefImpl)
	val SINGLE_ARG = LuaPlaceholderStub.Type("SINGLE_ARG", ::LuaSingleArgImpl)
	val LIST_ARGS = LuaPlaceholderStub.Type("LIST_ARGS", ::LuaListArgsImpl)

	val EXPR_LIST = LuaPlaceholderStub.Type("EXPR_LIST", ::LuaExprListImpl)
	val NAME_LIST = LuaPlaceholderStub.Type("NAME_LIST", ::LuaNameListImpl)
	val ASSIGN_STAT = LuaPlaceholderStub.Type("ASSIGN_STAT", ::LuaAssignStatImpl)
	val VAR_LIST = LuaPlaceholderStub.Type("VAR_LIST", ::LuaVarListImpl)
	val LOCAL_FUNC_DEF = LuaElementType("LOCAL_FUNC_DEF")
	val FUNC_BODY = LuaPlaceholderStub.Type("FUNC_BODY", ::LuaFuncBodyImpl)
	val CLASS_METHOD_NAME = LuaPlaceholderStub.Type("CLASS_METHOD_NAME", ::LuaClassMethodNameImpl)

	val PAREN_EXPR = LuaPlaceholderStub.Type("PAREN_EXPR", ::LuaParenExprImpl)
	val CALL_EXPR = LuaPlaceholderStub.Type("CALL_EXPR", ::LuaCallExprImpl)
	val CLOSURE_EXPR = LuaElementType("CLOSURE_EXPR")
	val UNARY_EXPR = LuaElementType("UNARY_EXPR")
	val BINARY_EXPR = LuaElementType("BINARY_EXPR")

	val RETURN_STAT = LuaPlaceholderStub.Type("RETURN_STAT", ::LuaReturnStatImpl)
	val DO_STAT = LuaPlaceholderStub.Type("DO_STAT", ::LuaDoStatImpl)
	val IF_STAT = LuaPlaceholderStub.Type("IF_STAT", ::LuaIfStatImpl)
	val EXPR_STAT = LuaPlaceholderStub.Type("CALL_STAT", ::LuaExprStatImpl)
}