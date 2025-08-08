package com.rendyrobbani.keuangan.common.marker;

public interface HasNameAndTitleMutator extends HasNameAndTitle {

	void setName(String name);

	void setTitlePrefix(String titlePrefix);

	void setTitleSuffix(String titleSuffix);

}