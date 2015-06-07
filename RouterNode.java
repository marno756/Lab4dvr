import javax.swing.*;
/* vim: set tabstop=4 softtabstop=4 shiftwidth=4 expandtab :*/


public class RouterNode {
  private int myID;
  private GuiTextArea myGUI;
  private RouterSimulator sim;
  private int[] costs = new int[RouterSimulator.NUM_NODES];

  //--------------------------------------------------
  public RouterNode(int ID, RouterSimulator sim, int[] costs) {
    myID = ID;
    this.sim = sim;
    myGUI =new GuiTextArea("  Output window for Router #"+ ID + "  ");

    System.arraycopy(costs, 0, this.costs, 0, RouterSimulator.NUM_NODES);
    caluclateInitialCost();

    for (int i = 0; i < RouterSimulator.NUM_NODES; i++) {
        RouterPacket pkt = new RouterPacket(myID, i, costs);
        sendUpdate(pkt);
    }
  }

  //--------------------------------------------------
  private void caluclateInitialCost() {
    // Initial Cost Calculation
  }

  //--------------------------------------------------
  public void recvUpdate(RouterPacket pkt) {

  }


  //--------------------------------------------------
  private void sendUpdate(RouterPacket pkt) {
    sim.toLayer2(pkt);

  }


  //--------------------------------------------------
  public void printDistanceTable() {
      myGUI.println("Current table for " + myID +
            "  at time " + sim.getClocktime());
  }

  //--------------------------------------------------
  public void updateLinkCost(int dest, int newcost) {
  }

}
