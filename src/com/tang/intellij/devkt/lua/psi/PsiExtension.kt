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

import com.tang.intellij.devkt.lua.lang.type.LuaString
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil

enum class LuaLiteralKind {
	String,
	Bool,
	Number,
	Nil,
	Unknown;

	companion object
}

val LuaLiteralExpr.kind: LuaLiteralKind
	get() {
		return when (node.firstChildNode.elementType) {
			LuaTypes.STRING -> LuaLiteralKind.String
			LuaTypes.TRUE -> LuaLiteralKind.Bool
			LuaTypes.FALSE -> LuaLiteralKind.Bool
			LuaTypes.NIL -> LuaLiteralKind.Nil
			LuaTypes.NUMBER -> LuaLiteralKind.Number
			else -> LuaLiteralKind.Unknown
		}
	}

val LuaLiteralExpr.stringValue: String
	get() {
		val content = LuaString.getContent(text)
		return content.value
	}

val LuaLiteralExpr.boolValue: Boolean get() = text == "true"

val LuaLiteralExpr.numberValue: Float get() = text.toFloat()

val LuaBinaryExpr.left: LuaExpr?
	get() {
		return PsiTreeUtil.getStubChildOfType(this, LuaExpr::class.java)
	}

val LuaBinaryExpr.right: LuaExpr?
	get() {
		val list = PsiTreeUtil.getStubChildrenOfTypeAsList(this, LuaExpr::class.java)
		return list.getOrNull(1)
	}