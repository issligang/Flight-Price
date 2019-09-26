package com.haina.flight.price.service.impl;

import com.haina.flight.price.constants.Constants;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ZkWatchServiceImpl implements Watcher {

    @Resource
    private ZooKeeper zooKeeper;

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
                try {
                    Stat stat = new Stat();
                    byte[] data = zooKeeper.getData(watchedEvent.getPath(), true, stat);
                    String str = new String(data);
                    Constants.abc = Integer.valueOf(str);

                    //zooKeeper.exists("/abc", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
