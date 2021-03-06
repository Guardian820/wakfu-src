package com.ankamagames.wakfu.client.network.protocol.message.game.serverToClient.personalSpace.room;

import com.ankamagames.baseImpl.client.proxyclient.base.network.protocol.message.*;

public class PSRoomRemoveContainerResultMessage extends InputOnlyProxyMessage
{
    private byte m_resultCode;
    
    public byte getResultCode() {
        return this.m_resultCode;
    }
    
    @Override
    public boolean decode(final byte[] rawDatas) {
        this.m_resultCode = rawDatas[0];
        return true;
    }
    
    @Override
    public int getId() {
        return 10032;
    }
}
