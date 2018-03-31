package com.at.wangxu.tree;

public class CreateTree {

    public static void create(TreeRoot treeRoot,int value){

        //如果树根为空（第一次访问），将第一个值作为根结点
        if (treeRoot.getTreeRoot()==null){
        treeRoot.setTreeRoot(new TreeNode(value));
        }else{
            TreeNode tmpNode=treeRoot.getTreeRoot();
            while (tmpNode!=null){
                if (value>tmpNode.getValue()){
                    if (tmpNode.getRightNode()==null){
                        tmpNode.setRightNode(new TreeNode(value));
                        return;
                    }else{
                        tmpNode=tmpNode.getRightNode();
                    }
                }else{
                    if (tmpNode.getLefTreeNode()==null){
                        tmpNode.setLefTreeNode(new TreeNode(value));
                        return;
                    }else {
                        tmpNode=tmpNode.getRightNode();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arrays = {2, 3, 1, 4, 5};

        //动态创建树

        TreeRoot root = new TreeRoot();
        for (int value : arrays) {
            create(root, value);
        }
        BinaryTree.inTraverseBTree(root.getTreeRoot());
        System.out.println(getHeight(root.getTreeRoot()));
        System.out.println(getMax(root.getTreeRoot()));
    }

    /**
     * 查找树的高度
     * @param treeNode
     * @return
     */
    public static int getHeight(TreeNode treeNode){

        if (treeNode==null)
            return 0;
        int left=getHeight(treeNode.getLefTreeNode());
        int right=getHeight(treeNode.getRightNode());
        return left<right?right+1:left+1;

    }

    /**
     * 找出树的最大值
     *
     * @param rootTreeNode
     */
    public static int  getMax(TreeNode rootTreeNode) {

        if (rootTreeNode == null) {
            return -1;
        } else {
            //找出左边的最大值
            int left = getMax(rootTreeNode.getLefTreeNode());

            //找出右边的最大值
            int right = getMax(rootTreeNode.getRightNode());

            //与当前根节点比较
            int currentRootValue = rootTreeNode.getValue();

            //假设左边的最大
            int max = left;


            if (right > max) {
                max = right;
            }
            if (currentRootValue > max) {
                max = currentRootValue;
            }

            return max ;


        }
    }
    /**
     * 非递归遍历二叉树
     */
    public static void preTreeNoRecursive(TreeNode treeNode){

    }

}
