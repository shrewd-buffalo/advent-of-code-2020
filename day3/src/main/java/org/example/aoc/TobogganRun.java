/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc;

/**
 * @author pshipley
 */
public class TobogganRun
{
    private final String render;
    private final int treesHit;
    private final int openSpacesVisited;

    public TobogganRun( final String render, final int treesHit, final int openSpacesVisited )
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
