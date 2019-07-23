import org.arl.unet.*
import org.arl.unet.phy.*
import org.arl.unet.*
import org.arl.unet.phy.*
import org.arl.unet.mac.*
import org.arl.unet.nodeinfo.NodeInfo
//import org.arl.unet.PDU 
import org.arl.fjage.*

import static org.arl.unet.Services.*
import static org.arl.unet.phy.Physical.*



subscribe phy
int hc =0;


// add a closure to define the 'ping' command
send = { count = 1 ->

   
    println "BRAOADCSTING BY SINK"
    count.times {
  phy << new DatagramReq(to: Address.BROADCAST, protocol: Protocol.DATA, data: [node.address, hc])
  //def txNtf = receive(TxFrameNtf, 1000)
  //def rxNtf = receive({ it instanceof RxFrameNtf && it.from == i}, 5000)
    //if (txNtf && rxNtf && rxNtf.from == i)
      //println "Data Received at ${rxNtf.from} from ${rxNtf.to} is: ${rxNtf.data}"
    }
}
