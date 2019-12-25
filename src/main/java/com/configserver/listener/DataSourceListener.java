package com.configserver.listener;

import com.configserver.pojo.CustomDataSource;
import com.configserver.pojo.RuntimeContext;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * FileName: MyListener
 * Author:   程序猿不是猴
 * Date:     2019/12/5 10:51
 * Description: 监听zk节点变化
 */

@SuppressWarnings("all")
public class DataSourceListener implements ServletContextListener {

    private ZkClient zkClient;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized ...");
        try {
            zkClient = new ZkClient("192.168.109.206:2181");

            zkClient.subscribeDataChanges("/datasource/url", new IZkDataListener() {

                @Override
                public void handleDataChange(String dataPath, Object data) throws Exception {
                    CustomDataSource dataSource = (CustomDataSource) RuntimeContext.getBean("dataSource");
                    System.out.println("修改前：" + dataSource.getUrl());
                    dataSource.setUrl(data.toString());
                    System.out.println("修改后：" + dataSource.getUrl());
                    dataSource.refresh();
                }

                @Override
                public void handleDataDeleted(String dataPath) throws Exception {

                }
            });
        } catch (Exception e) {
            if (zkClient != null) {
                zkClient.close();
            }
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        zkClient.close();
    }
}