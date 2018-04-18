// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.LuaDocGenericTy;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocTy;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class LuaDocGenericTyImpl extends LuaDocTyImpl implements LuaDocGenericTy {

	public LuaDocGenericTyImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitGenericTy(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<LuaDocTy> getTyList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaDocTy.class);
	}

}
