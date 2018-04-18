// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaUnaryExpr;
import com.tang.intellij.devkt.lua.psi.LuaUnaryOp;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaUnaryExprImpl extends LuaExprImpl implements LuaUnaryExpr {

	public LuaUnaryExprImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitUnaryExpr(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaExpr getExpr() {
		return findChildByClass(LuaExpr.class);
	}

	@Override
	@NotNull
	public LuaUnaryOp getUnaryOp() {
		return findNotNullChildByClass(LuaUnaryOp.class);
	}

}
