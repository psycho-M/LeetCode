public class Codec {
    String origUrl;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        origUrl = longUrl;
        return origUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return origUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));