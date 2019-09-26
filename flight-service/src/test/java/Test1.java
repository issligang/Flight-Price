import java.util.ArrayList;
import java.util.List;

public class Test1 implements ICommonTree{

    private Node[] nodes = (Node[]) new Node().child.toArray();
    private List<Node> list = new Node().child;

    @Override
    public void addNode(Integer pId, Node newNode) {
        if(nodes.length<2*pId+1){
            list.add(newNode);
            nodes = (Node[]) list.toArray();
        }
        if(nodes.length<2*pId+2) {
            list.add(newNode);
            nodes = (Node[]) list.toArray();
        }
    }

    @Override
    public void removeNode(Integer nodeId) {

    }

    @Override
    public void showNode(Integer pId, Integer cId) {
        if((pId*2+1 == cId) || (pId*2+2 == cId)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
