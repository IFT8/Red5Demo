package cn.ift8.red5;

import org.red5.server.adapter.MultiThreadedApplicationAdapter;
import org.red5.server.api.Red5;
import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IBroadcastStream;

/**
 * Created by IFT8
 * on 2015/4/17.
 */
public class ArenaRTMPServices extends MultiThreadedApplicationAdapter {

    @Override
    public boolean appStart(IScope arg0) {
        System.out.println("----------appStart--------");
        return super.appStart(arg0);
    }

    @Override
    public void streamBroadcastStart(IBroadcastStream stream) {
        System.out.println("------streamBroadcastStart-----");
        System.out.println("getName  " + stream.getName());
        System.out.println("getPublishedName   " + stream.getPublishedName());
        super.streamBroadcastStart(stream);
    }

    @Override
    public void streamPublishStart(IBroadcastStream stream) {
        String ip = Red5.getConnectionLocal().getHost();
        System.out.println("------streamPublishStart-----");
        System.out.println("getName   " + stream.getName());
        System.out.println("Red5.getConnectionLocal().getHost()    " + ip);
        String passIP = ProperUtils.checkIp();
        if (ip == null || null != passIP && !"".equals(passIP) && !ip.equals(passIP)) {
            Red5.getConnectionLocal().close();
            stream.close();
        }
        super.streamPublishStart(stream);
    }

}
