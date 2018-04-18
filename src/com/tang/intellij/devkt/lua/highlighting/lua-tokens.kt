package com.tang.intellij.devkt.lua.highlighting

import com.tang.intellij.devkt.lua.comment.psi.LuaDocTypes
import com.tang.intellij.devkt.lua.psi.LuaTypes
import org.jetbrains.kotlin.com.intellij.psi.tree.TokenSet

val KEYWORD_TOKENS = TokenSet.create(
		LuaTypes.AND,
		LuaTypes.BREAK,
		LuaTypes.DO,
		LuaTypes.ELSE,
		LuaTypes.ELSEIF,
		LuaTypes.END,
		LuaTypes.FOR,
		LuaTypes.FUNCTION,
		LuaTypes.IF,
		LuaTypes.IN,
		LuaTypes.LOCAL,
		LuaTypes.NOT,
		LuaTypes.OR,
		LuaTypes.REPEAT,
		LuaTypes.RETURN,
		LuaTypes.THEN,
		LuaTypes.UNTIL,
		LuaTypes.WHILE,

		//lua5.3
		LuaTypes.DOUBLE_COLON,
		LuaTypes.GOTO
)
val PRIMITIVE_TYPE_SET = TokenSet.create(
		LuaTypes.FALSE,
		LuaTypes.NIL,
		LuaTypes.TRUE
)
val DOC_TAG_TOKENS = TokenSet.create(
		LuaDocTypes.TAG_PARAM,
		LuaDocTypes.TAG_RETURN,
		LuaDocTypes.TAG_CLASS,
		LuaDocTypes.TAG_MODULE,
		LuaDocTypes.TAG_TYPE,
		LuaDocTypes.TAG_FIELD,
		LuaDocTypes.TAG_LANGUAGE,
		LuaDocTypes.TAG_OVERLOAD,
		LuaDocTypes.TAG_PRIVATE,
		LuaDocTypes.TAG_PROTECTED,
		LuaDocTypes.TAG_PUBLIC,
		LuaDocTypes.TAG_SEE,
		LuaDocTypes.TAG_GENERIC
)

private val DOC_KEYWORD_TOKENS = TokenSet.create(
		LuaDocTypes.FUN
)
