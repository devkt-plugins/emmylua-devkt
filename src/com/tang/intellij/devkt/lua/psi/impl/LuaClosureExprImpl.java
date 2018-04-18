// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaClosureExpr;
import com.tang.intellij.devkt.lua.psi.LuaFuncBody;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaClosureExprImpl extends LuaExprImpl implements LuaClosureExpr {

	public LuaClosureExprImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitClosureExpr(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public LuaFuncBody getFuncBody() {
		return findNotNullChildByClass(LuaFuncBody.class);
	}

}
