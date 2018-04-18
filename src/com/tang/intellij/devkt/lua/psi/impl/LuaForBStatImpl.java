// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExprList;
import com.tang.intellij.devkt.lua.psi.LuaForBStat;
import com.tang.intellij.devkt.lua.psi.LuaParamNameDef;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class LuaForBStatImpl extends LuaStatementImpl implements LuaForBStat {

	public LuaForBStatImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitForBStat(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaExprList getExprList() {
		return findChildByClass(LuaExprList.class);
	}

	@Override
	@NotNull
	public List<LuaParamNameDef> getParamNameDefList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaParamNameDef.class);
	}

}
