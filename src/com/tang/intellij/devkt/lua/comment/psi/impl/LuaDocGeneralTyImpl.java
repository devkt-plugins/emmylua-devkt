// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.LuaDocClassNameRef;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocGeneralTy;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaDocGeneralTyImpl extends LuaDocTyImpl implements LuaDocGeneralTy {

	public LuaDocGeneralTyImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitGeneralTy(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public LuaDocClassNameRef getClassNameRef() {
		return findNotNullChildByClass(LuaDocClassNameRef.class);
	}

}
