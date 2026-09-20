package com.nhlstenden.appstores;

public class DownloadNotAllowedException extends RuntimeException
{
    public DownloadNotAllowedException(String message)
    {
        super(message);
    }
}
