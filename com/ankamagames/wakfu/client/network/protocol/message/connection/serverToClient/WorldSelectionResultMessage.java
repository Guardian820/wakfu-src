package com.ankamagames.wakfu.client.network.protocol.message.connection.serverToClient;

import com.ankamagames.baseImpl.client.proxyclient.base.network.protocol.message.*;
import java.nio.*;

public class WorldSelectionResultMessage extends InputOnlyProxyMessage
{
    private byte m_errorCode;
    
    @Override
    public boolean decode(final byte[] rawDatas) {
        final ByteBuffer buffer = ByteBuffer.wrap(rawDatas);
        this.m_errorCode = buffer.get();
        return true;
    }
    
    @Override
    public int getId() {
        return 1202;
    }
    
    public byte getErrorCode() {
        return this.m_errorCode;
    }
}
