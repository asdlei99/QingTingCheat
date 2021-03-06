package weibo4android;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

public class Configuration
{
  private static boolean DALVIK;
  private static Properties defaultProperty;

  static
  {
    init();
  }

  public static boolean getBoolean(String paramString)
  {
    return Boolean.valueOf(getProperty(paramString)).booleanValue();
  }

  public static String getCilentVersion()
  {
    return getProperty("weibo4j.clientVersion");
  }

  public static String getCilentVersion(String paramString)
  {
    return getProperty("weibo4j.clientVersion", paramString);
  }

  public static String getClientURL()
  {
    return getProperty("weibo4j.clientURL");
  }

  public static String getClientURL(String paramString)
  {
    return getProperty("weibo4j.clientURL", paramString);
  }

  public static int getConnectionTimeout()
  {
    return getIntProperty("weibo4j.http.connectionTimeout");
  }

  public static int getConnectionTimeout(int paramInt)
  {
    return getIntProperty("weibo4j.http.connectionTimeout", paramInt);
  }

  public static boolean getDebug()
  {
    return getBoolean("weibo4j.debug");
  }

  public static int getIntProperty(String paramString)
  {
    String str = getProperty(paramString);
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1;
  }

  public static int getIntProperty(String paramString, int paramInt)
  {
    String str = getProperty(paramString, String.valueOf(paramInt));
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1;
  }

  public static long getLongProperty(String paramString)
  {
    String str = getProperty(paramString);
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1L;
  }

  public static int getNumberOfAsyncThreads()
  {
    return getIntProperty("weibo4j.async.numThreads");
  }

  public static String getOAuthConsumerKey()
  {
    return getProperty("weibo4j.oauth.consumerKey");
  }

  public static String getOAuthConsumerKey(String paramString)
  {
    return getProperty("weibo4j.oauth.consumerKey", paramString);
  }

  public static String getOAuthConsumerSecret()
  {
    return getProperty("weibo4j.oauth.consumerSecret");
  }

  public static String getOAuthConsumerSecret(String paramString)
  {
    return getProperty("weibo4j.oauth.consumerSecret", paramString);
  }

  public static String getPassword()
  {
    return getProperty("weibo4j.password");
  }

  public static String getPassword(String paramString)
  {
    return getProperty("weibo4j.password", paramString);
  }

  public static String getProperty(String paramString)
  {
    return getProperty(paramString, null);
  }

  public static String getProperty(String paramString1, String paramString2)
  {
    try
    {
      localObject = System.getProperty(paramString1, paramString2);
      if (localObject == null)
        localObject = defaultProperty.getProperty(paramString1);
      if (localObject == null)
      {
        String str1 = defaultProperty.getProperty(paramString1 + ".fallback");
        if (str1 != null)
        {
          String str2 = System.getProperty(str1);
          localObject = str2;
        }
      }
      return replace((String)localObject);
    }
    catch (AccessControlException localAccessControlException)
    {
      while (true)
        Object localObject = paramString2;
    }
  }

  public static String getProxyHost()
  {
    return getProperty("weibo4j.http.proxyHost");
  }

  public static String getProxyHost(String paramString)
  {
    return getProperty("weibo4j.http.proxyHost", paramString);
  }

  public static String getProxyPassword()
  {
    return getProperty("weibo4j.http.proxyPassword");
  }

  public static String getProxyPassword(String paramString)
  {
    return getProperty("weibo4j.http.proxyPassword", paramString);
  }

  public static int getProxyPort()
  {
    return getIntProperty("weibo4j.http.proxyPort");
  }

  public static int getProxyPort(int paramInt)
  {
    return getIntProperty("weibo4j.http.proxyPort", paramInt);
  }

  public static String getProxyUser()
  {
    return getProperty("weibo4j.http.proxyUser");
  }

  public static String getProxyUser(String paramString)
  {
    return getProperty("weibo4j.http.proxyUser", paramString);
  }

  public static int getReadTimeout()
  {
    return getIntProperty("weibo4j.http.readTimeout");
  }

  public static int getReadTimeout(int paramInt)
  {
    return getIntProperty("weibo4j.http.readTimeout", paramInt);
  }

  public static int getRetryCount()
  {
    return getIntProperty("weibo4j.http.retryCount");
  }

  public static int getRetryCount(int paramInt)
  {
    return getIntProperty("weibo4j.http.retryCount", paramInt);
  }

  public static int getRetryIntervalSecs()
  {
    return getIntProperty("weibo4j.http.retryIntervalSecs");
  }

  public static int getRetryIntervalSecs(int paramInt)
  {
    return getIntProperty("weibo4j.http.retryIntervalSecs", paramInt);
  }

  public static String getScheme()
  {
    if (useSSL())
      return "https://";
    return "http://";
  }

  public static String getSource()
  {
    return getProperty("weibo4j.source");
  }

  public static String getSource(String paramString)
  {
    return getProperty("weibo4j.source", paramString);
  }

  public static String getUser()
  {
    return getProperty("weibo4j.user");
  }

  public static String getUser(String paramString)
  {
    return getProperty("weibo4j.user", paramString);
  }

  public static String getUserAgent()
  {
    return getProperty("weibo4j.http.userAgent");
  }

  public static String getUserAgent(String paramString)
  {
    return getProperty("weibo4j.http.userAgent", paramString);
  }

  static void init()
  {
    defaultProperty = new Properties();
    defaultProperty.setProperty("weibo4j.debug", "true");
    defaultProperty.setProperty("weibo4j.source", Weibo.CONSUMER_KEY);
    defaultProperty.setProperty("weibo4j.clientURL", "http://open.t.sina.com.cn/-{weibo4j.clientVersion}.xml");
    defaultProperty.setProperty("weibo4j.http.userAgent", "weibo4j http://open.t.sina.com.cn/ /{weibo4j.clientVersion}");
    defaultProperty.setProperty("weibo4j.http.useSSL", "false");
    defaultProperty.setProperty("weibo4j.http.proxyHost.fallback", "http.proxyHost");
    defaultProperty.setProperty("weibo4j.http.proxyPort.fallback", "http.proxyPort");
    defaultProperty.setProperty("weibo4j.http.connectionTimeout", "20000");
    defaultProperty.setProperty("weibo4j.http.readTimeout", "120000");
    defaultProperty.setProperty("weibo4j.http.retryCount", "3");
    defaultProperty.setProperty("weibo4j.http.retryIntervalSecs", "10");
    defaultProperty.setProperty("weibo4j.async.numThreads", "1");
    defaultProperty.setProperty("weibo4j.clientVersion", Version.getVersion());
    try
    {
      Class.forName("dalvik.system.VMRuntime");
      defaultProperty.setProperty("weibo4j.dalvik", "true");
      DALVIK = getBoolean("weibo4j.dalvik");
      if ((!loadProperties(defaultProperty, "." + File.separatorChar + "weibo4j.properties")) && (!loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/" + "weibo4j.properties"))) && (loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/" + "weibo4j.properties"))));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        defaultProperty.setProperty("weibo4j.dalvik", "false");
    }
  }

  public static boolean isDalvik()
  {
    return DALVIK;
  }

  private static boolean loadProperties(Properties paramProperties, InputStream paramInputStream)
  {
    try
    {
      paramProperties.load(paramInputStream);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static boolean loadProperties(Properties paramProperties, String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramProperties.load(new FileInputStream(localFile));
        return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static String replace(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return paramString;
      int i = paramString.indexOf("{", 0);
      int j;
      String str2;
      if (-1 != i)
      {
        j = paramString.indexOf("}", i);
        if (j > i + 1)
        {
          str2 = paramString.substring(i + 1, j);
          if (str2.length() <= 0);
        }
      }
      for (String str1 = paramString.substring(0, i) + getProperty(str2) + paramString.substring(j + 1); !str1.equals(paramString); str1 = paramString)
        return replace(str1);
    }
  }

  public static boolean useSSL()
  {
    return getBoolean("weibo4j.http.useSSL");
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     weibo4android.Configuration
 * JD-Core Version:    0.6.2
 */