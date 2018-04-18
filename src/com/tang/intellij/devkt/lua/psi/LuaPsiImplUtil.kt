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

@file:Suppress("UNUSED_PARAMETER")

package com.tang.intellij.devkt.lua.psi

import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil

fun getParamSignature(funcBodyOwner: LuaFuncBodyOwner): String {
	val params = funcBodyOwner.params
	val list = arrayOfNulls<String>(params.size)
	for (i in params.indices) {
		val lpi = params[i]
		list[i] = lpi.name
	}
	return "(" + list.joinToString(", ") + ")"
}

fun getExpr(exprStat: LuaExprStat): LuaExpr {
	return PsiTreeUtil.getStubChildOfType(exprStat, LuaExpr::class.java)!!
}