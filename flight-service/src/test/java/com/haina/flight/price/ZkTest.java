package com.haina.flight.price;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;

public class ZkTest implements Watcher {

    @Test
    public void test(){
        ZkTest zkTest = new ZkTest();
        try {
            //创建zk对象
            //第一个参数，服务的ip端口信息
            //第二个参数，超时时间
            //第三个参数，watch对象
            String ip = "10.0.100.244:2181";
            int timeOut = 3000;
            ZooKeeper zooKeeper = new ZooKeeper(ip, timeOut, zkTest);

            //创建：1、节点路径 2、节点值byte 3、节点权限 4、节点类型
            // 不能够2次创建！！！
            String s = zooKeeper.create("/abc", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(s);

            Stat stat = new Stat();
            //查询：1、路径名 2、是否要监听 3、节点的状态对象
            byte[] data = zooKeeper.getData("/abc", true, stat);
            System.out.println(new String(data));

            //修改：1、路径名 2、节点值byte
            zooKeeper.setData("/abc", "1234".getBytes(), stat.getVersion());

            data = zooKeeper.getData("/abc", true, stat);
            System.out.println(new String(data));

            //删除：1、路径名
            //zooKeeper.delete("/abc", stat.getVersion());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                System.out.println("连接上了服务器");
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                //字节点发生变化的状态
                System.out.println("节点发生了变化");
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                System.out.println("节点的值发生了变化");
                System.out.println("改变的path是:" + watchedEvent.getPath());
            }
        }
    }
}
