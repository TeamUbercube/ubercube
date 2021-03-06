/*
 * Copyright (C) 2016 Team Ubercube
 *
 * This file is part of Ubercube.
 *
 *     Ubercube is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Ubercube is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Ubercube.  If not, see http://www.gnu.org/licenses/.
 */

package fr.veridiangames.core.network.packets;

import fr.veridiangames.core.network.NetworkableClient;
import fr.veridiangames.core.network.NetworkableServer;
import fr.veridiangames.core.utils.DataBuffer;

import java.net.InetAddress;

/**
 * Created by Marccspro on 13/07/2016.
 */
public class TchatMsgPacket extends Packet
{
    private String msg;

    public TchatMsgPacket()

    {
        super(TCHAT_MSG);
    }

    public TchatMsgPacket(String msg)
    {
        super(TCHAT_MSG);
        data.put(msg);
        data.flip();
    }

    public TchatMsgPacket(TchatMsgPacket packet)
    {
        super(TCHAT_MSG);
        data.put(packet.msg);
        data.flip();
    }

    public void read(DataBuffer buffer)
    {
        this.msg = buffer.getString();
    }

    public void process(NetworkableServer server, InetAddress address, int port)
    {
        server.log(msg);
        server.tcpSendToAll(new TchatMsgPacket(msg));
    }

    public void process(NetworkableClient client, InetAddress address, int port)
    {
        client.log(msg);
        client.console(msg);
    }
}
