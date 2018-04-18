// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.LuaDocFunctionParam;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocFunctionTy;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocTypeList;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class LuaDocFunctionTyImpl extends LuaDocTyImpl implements LuaDocFunctionTy {

	public LuaDocFunctionTyImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitFunctionTy(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<LuaDocFunctionParam> getFunctionParamList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaDocFunctionParam.class);
	}

	@Override
	@Nullable
	public LuaDocTypeList getTypeList() {
		return findChildByClass(LuaDocTypeList.class);
	}

}
