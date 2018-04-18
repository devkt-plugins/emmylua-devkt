// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaBinaryExpr;
import com.tang.intellij.devkt.lua.psi.LuaBinaryOp;
import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaBinaryExprImpl extends LuaExprImpl implements LuaBinaryExpr {

	public LuaBinaryExprImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitBinaryExpr(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public LuaBinaryOp getBinaryOp() {
		return findNotNullChildByClass(LuaBinaryOp.class);
	}

	@Override
	@Nullable
	public LuaExpr getExpr() {
		return findChildByClass(LuaExpr.class);
	}

}
