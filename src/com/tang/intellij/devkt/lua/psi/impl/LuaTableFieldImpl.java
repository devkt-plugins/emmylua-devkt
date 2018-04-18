// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaTableField;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

import static com.tang.intellij.devkt.lua.psi.LuaTypes.ID;

public class LuaTableFieldImpl extends ASTWrapperPsiElement implements LuaTableField {

	public LuaTableFieldImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitTableField(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<LuaExpr> getExprList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaExpr.class);
	}

	@Override
	@Nullable
	public PsiElement getId() {
		return findChildByType(ID);
	}

}
