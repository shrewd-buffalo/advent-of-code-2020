/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3a;

/**
 * @author pshipley
 */
public class TobagganRun
{
    private final String render;
    private final int treesHit;
    private final int openSpacesVisited;

    public TobagganRun( final String render, final int treesHit, final int openSpacesVisited )
    {

        this.render = render;
        this.treesHit = treesHit;
        this.openSpacesVisited = openSpacesVisited;
    }

    /**
     * @return The render.
     */
    public String getRender()
    {
        return render;
    }

    /**
     * @return The treesHit.
     */
    public int getTreesHit()
    {
        return treesHit;
    }

    /**
     * @return The openSpacesVisited.
     */
    public int getOpenSpacesVisited()
    {
        return openSpacesVisited;
    }
}
