package puzzle;

/**
 * Created by Zhong on 2014/7/14.
 */
public class BinaryTree<T> {

    private Node root;

    public int getNodeCount() {
        return nodeCount;
    }

    public static class Node<T> {
        private Node leftChild;
        private Node rightChild;
        private T data;

        private Node(Node leftChild, Node rightChild, T data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public T getData() {
            return data;
        }
    }

    private int nodeCount;

    public void iteration(IterationStrategy strategy, Visitor<Node> visitor) {
        strategy.visit(root, visitor);
    }

    public static enum IterationStrategy {
        PRE_ORDER {
            @Override
            void visit(Node root, Visitor<Node> visitor) {
                if (root != null) {
                    visitor.visit(root);
                    visit(root.getLeftChild(), visitor);
                    visit(root.getRightChild(), visitor);
                }
            }
        }, IN_ORDER {
            @Override
            void visit(Node root, Visitor<Node> visitor) {
                if (root != null) {
                    visit(root.getLeftChild(), visitor);
                    visitor.visit(root);
                    visit(root.getRightChild(), visitor);
                }
            }
        }, POST_ORDER {
            @Override
            void visit(Node root, Visitor<Node> visitor) {
                if (root != null) {
                    visit(root.getLeftChild(), visitor);
                    visit(root.getRightChild(), visitor);
                    visitor.visit(root);
                }
            }
        };

        abstract void visit(Node root, Visitor<Node> visitor);
    }


}
