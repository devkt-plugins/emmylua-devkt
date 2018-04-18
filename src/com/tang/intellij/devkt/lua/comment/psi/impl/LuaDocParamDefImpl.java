// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaDocParamDefImpl extends ASTWrapperPsiElement implements LuaDocParamDef {

	public LuaDocParamDefImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitParamDef(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaDocCommentString getCommentString() {
		return findChildByClass(LuaDocCommentString.class);
	}

	@Override
	@Nullable
	public LuaDocParamNameRef getParamNameRef() {
		return findChildByClass(LuaDocParamNameRef.class);
	}

	@Override
	@Nullable
	public LuaDocTy getTy() {
		return findChildByClass(LuaDocTy.class);
	}

}
