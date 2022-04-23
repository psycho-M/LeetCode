public class Codec {
    Map<String, String> map = new HashMap<>();
    String origUrl;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        origUrl = longUrl;
        // return origUrl;
        StringBuilder sb = new StringBuilder("https://tinyurl.com/");
        String[] str = longUrl.split("/");
        // print(str);
        for(int i = 4; i < str.length; i++) 
            sb.append(str[i].length() + str[i].substring(0, 1));
        
        String shortUrl = sb.toString();
        map.put(shortUrl, longUrl);
        return shortUrl;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    
    void print(String[] str) {
        for(String s : str) System.out.print(s + ", ");
        System.out.println();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));