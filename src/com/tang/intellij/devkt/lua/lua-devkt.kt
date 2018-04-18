package com.tang.intellij.devkt.lua

import com.tang.intellij.devkt.lua.highlighting.*
import com.tang.intellij.devkt.lua.lang.LuaLanguage
import com.tang.intellij.devkt.lua.lang.LuaParserDefinition
import com.tang.intellij.devkt.lua.psi.LuaStringTypes
import com.tang.intellij.devkt.lua.psi.LuaTypes
import org.ice1000.devkt.openapi.ColorScheme
import org.ice1000.devkt.openapi.ExtendedDevKtLanguage
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType

class EmmyLua<T> : ExtendedDevKtLanguage<T>(
		LuaLanguage.INSTANCE,
		LuaParserDefinition()
) {
	override fun attributesOf(type: IElementType, colorScheme: ColorScheme<T>) = when (type) {
		LuaTypes.DOC_COMMENT -> colorScheme.docComments
		LuaStringTypes.NEXT_LINE -> colorScheme.stringEscape
		LuaTypes.LPAREN, LuaTypes.RPAREN -> colorScheme.parentheses
		LuaTypes.LBRACK, LuaTypes.RBRACK -> colorScheme.brackets
		in DOC_TAG_TOKENS -> colorScheme.docComments
		in PRIMITIVE_TYPE_SET -> colorScheme.keywords
		in KEYWORD_TOKENS -> colorScheme.keywords
		else -> super.attributesOf(type, colorScheme)
	}
}
