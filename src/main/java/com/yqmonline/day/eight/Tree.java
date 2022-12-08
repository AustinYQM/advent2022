package com.yqmonline.day.eight;

public class Tree {
    private final int height;
    private Tree left, right, top, bottom;

    public Tree(int height) {
        this.height = height;
    }

    public boolean allLeftLower() {
        return left == null || left.allLeftLower(height);
    }

    public boolean allRightLower() {
        return right == null || right.allRightLower(height);
    }

    public boolean allTopLower() {
        return top == null || top.allTopLower(height);
    };

    public boolean allBottomLower() {
        return bottom == null || bottom.allBottomLower(height);
    }

    private boolean allLeftLower(int startTreeHeight) {
        return isLower(startTreeHeight) && (left == null || left.allLeftLower(startTreeHeight));
    }

    private boolean allRightLower(int startTreeHeight) {
        return isLower(startTreeHeight) && (right == null || right.allRightLower(startTreeHeight));
    }

    private boolean allTopLower(int startTreeHeight) {
        return isLower(startTreeHeight) && (top == null || top.allTopLower(startTreeHeight));
    }

    private boolean allBottomLower(int startTreeHeight) {
        return isLower(startTreeHeight) && (bottom == null || bottom.allBottomLower(startTreeHeight));
    }

    private boolean isLower(int startTreeHeight) {
        return height < startTreeHeight;
    }

    private int viewToLeft(int startTreeHeight) {
        if (left == null || isHigherOrSameHight(startTreeHeight)) // no more (lower) trees
            return 0;
        else
            return 1 + left.viewToLeft(startTreeHeight); // +1 and ask the next visible tree
    }

    private int viewToRight(int startTreeHeight) {
        if (right == null || isHigherOrSameHight(startTreeHeight))
            return 0;
        else
            return 1 + right.viewToRight(startTreeHeight);
    }

    private int viewToTop(int startTreeHeight) {
        if (top == null || isHigherOrSameHight(startTreeHeight))
            return 0;
        else
            return 1 + top.viewToTop(startTreeHeight);
    }

    private int viewToBottom(int startTreeHeight) {
        if (bottom == null || isHigherOrSameHight(startTreeHeight))
            return 0;
        else
            return 1 + bottom.viewToBottom(startTreeHeight);
    }

    public int scenicScore() {
        int viewToLeft = left == null ? 0 : 1 + left.viewToLeft(height);
        int viewToRight = right == null ? 0 : 1 + right.viewToRight(height);
        int viewToTop = top == null ? 0 : 1 + top.viewToTop(height);
        int viewToBottom = bottom == null ? 0 : 1 + bottom.viewToBottom(height);

        return viewToLeft * viewToRight * viewToTop * viewToBottom;
    }

    private boolean isHigherOrSameHight(int startHeight) {
        return height > startHeight || height == startHeight;
    }

    public int getHeight() {
        return height;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public void setTop(Tree top) {
        this.top = top;
    }

    public void setBottom(Tree bottom) {
        this.bottom = bottom;
    }
}
