import java.util.List;

class Node{
    Integer id;
    Node parent;
    List<Node> child;
}

public interface ICommonTree {

    public void addNode(Integer pId,Node newNode);

    public void removeNode(Integer nodeId);

    public void showNode(Integer pId,Integer cId);


}
