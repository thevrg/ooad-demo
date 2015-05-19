package com.epam.edu.decorator;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author tmp
 */
public class CharacterChangerFilterReader extends FilterReader {

    public CharacterChangerFilterReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c =  super.read();
        if (c == '<') {
            c = '#';
        }
        return c;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int readChars = super.read(cbuf, off, len);
        
        for (int i = off; i < off + readChars; i++) {
            char c = cbuf[i];
            if (c == '<') {
                cbuf[i]='#';
            }
        }
        return readChars;
    }

}
