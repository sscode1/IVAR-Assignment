import org.arl.fjage.*
import org.arl.unet.*
import org.arl.unet.phy.*
import org.arl.unet.sim.*
import org.arl.unet.sim.channels.*
import static org.arl.unet.Services.*
import static org.arl.unet.phy.Physical.*
import org.arl.unet.sim.channels.*

channel.model = ProtocolChannelModel

channel.soundSpeed = 1500.mps           // c
channel.communicationRange = 300.m     // Rc
channel.detectionRange = 300.m        // Rd
channel.interferenceRange = 3000.m      // Ri
channel.pDetection = 1                  // pd
channel.pDecoding = 1                   // pc

//!Simulation
simulate {
  node '1', address: 1, remote: 1101, shell: true,location: [0, 0, 0], stack: { container ->
    //container.add 'ivr', new IVR()
    container.shell.addInitrc "${script.parent}/fshrc.groovy"
  }
  node '2', address: 2,remote: 1102, shell: 5102,location: [-200.m, 0,-300.m], stack: { container ->
   container.add 'ivr', new IVR()
   
  }
 node '3', address: 3,remote: 1103, shell: 5103,location: [0, 0, -300.m], stack: { container ->
    container.add 'ivr', new IVR()
   
  }
  node '4', address: 4,remote: 1104, shell: 5104,location: [200.m, 0,-300.m], stack: { container ->
    container.add 'ivr', new IVR()
    //container.shell.addInitrc "${script.parent}/fshrc.groovy"
  }
  node '5', address: 5,remote: 1105, shell: 5105,location: [-200.m, 0, -600.m], stack: { container ->
    container.add 'ivr', new IVR()
    //container.shell.addInitrc "${script.parent}/fshrc.groovy"
  }
  
}

