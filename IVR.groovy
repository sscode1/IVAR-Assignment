import org.arl.fjage.*
import org.arl.unet.*
import org.arl.unet.phy.*
import org.arl.unet.sim.*
import org.arl.unet.sim.channels.*
import static org.arl.unet.Services.*
import static org.arl.unet.phy.Physical.*
import org.arl.unet.nodeinfo.NodeInfo
import org.arl.unet.mac.*

class IVR extends UnetAgent {
int hc, neighbor;
int addr
  final static int PROTOCOL = Protocol.DATA
  
  //int hopcount=100
  void startup() {
    def phy = agentForService Services.PHYSICAL
    subscribe topic(phy);
     
     //def mac = agentForService Services.MAC
    // subscribe topic(mac);

    def nodeInfo = agentForService Services.NODE_INFO;
    addr = nodeInfo.address
    
    
   }

  void processMessage(Message msg) {
    if (msg instanceof DatagramNtf && msg.protocol == PROTOCOL)
    {
      neighbor = msg.data[0];
      hc = msg.data[1];
      hc= hc +1;
      send new DatagramReq(recipient: msg.sender,to: Address.BROADCAST, protocol: Protocol.MAC, data: [addr, hc])
      
      }
    }
  }


