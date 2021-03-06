package io.novaordis.playground.swim.simplest;

import recon.Value;
import swim.client.SwimClient;

public class SendingClient {

    public static void main(String[] args) {

        final SwimClient client = new SwimClient();

        client.start();

        client.
                hostRef("ws://localhost:9009").
                nodeRef("a/device1").
                laneRef("metric").
                downlinkValue().
                keepSynced(true).
                open().
                didSet((newValue, oldValue) -> {

                    //
                    // we use this callback to close the client and exit after the first set on lane is
                    // *guaranteed* to have reached the server and came back; the client should stay up
                    // until then
                    //

                    System.out.println("exiting ...");

                    client.stop();
                    client.close();

                }).
                set(Value.of("something"));

    }

}
