package telegram.commands.util;

import java.util.Map;

import static java.util.Map.entry;

public enum fromCardStringToId {
    Instance;
    private final String stickersPrefix = "CAACAgQAAxkBAAEGz";
    private final Integer prefixLength = stickersPrefix.length();
    public final static Map<String, String> data = Map.ofEntries(
            entry("b_reverse", "UJjlzHBKAmAr2tW3tImIyB_7ghiPQACAgAD1XH9MdashQABTzwLDisE"),
            entry("g_reverse","URjlzHG0DbZub0nm8OiGvI_7k1n5AACAwAD1XH9MbYJ3m4hN6wBKwQ"),
            entry("r_reverse","UZjlzHIqMeEQHjPEzzoO1wzcOrvsQACBAAD1XH9MV0kRSAPQPr-KwQ"),
            entry("y_reverse","UhjlzHKqNcyzhdPXGXHoPwN8Ur6tgACBQAD1XH9MSLyLuaKRl3zKwQ"),
            entry("b_block","UpjlzHLiIxX5AvmLDn6w4kPhSv7JgACBgAD1XH9MVcsmdqhfWjxKwQ"),
            entry("g_block","UxjlzHmwSobLQs60KUOLFyggOjvcAACBwAD1XH9MZUg-s3xrWNkKwQ"),
            entry("r_block","U5jlzHoZ7DbQhNeWtd-AtkTflc3kQACCAAD1XH9MZzc-U31QHClKwQ"),
            entry("y_block","VBjlzHqL_2lKuGylfDSQsltGvLAEgACCQAD1XH9MXjDnpQAAdiqJSsE"),
            entry("change_color","VJjlzHtz8tCsPUg24S-FjiLm6S6YwACCgAD1XH9MYfiF_tHgutLKwQ"),
            entry("draw_4","VRjlzHvKW7NSxtH0M1Ps1j8HdwpGQACCwAD1XH9MWXLImuKLy1gKwQ"),
            entry("b_0","VZjlzHycFrtvOL3bJGD6wi_EWdePQACDAAD1XH9MTf5oSgOnIUnKwQ"),
            entry("g_0","VhjlzH09KU6on7xPEHK6j2ebmKIcQACDQAD1XH9MfFINHGq9R6-KwQ"),
            entry("r_0","VpjlzH2Wg0L8ZBvncdm-dp07_DbngACDgAD1XH9MTkoTHPl4e4ZKwQ"),
            entry("y_0","VxjlzH3zGLUv_9ReWe-BcMTpH06jAACDwAD1XH9MWxA6xffn6lIKwQ"),
            entry("b_1","V5jlzH5w7NFxJVWNBzWBmPa9ga8KQACEAAD1XH9MdnIL8X73EvFKwQ"),
            entry("g_1","WBjlzH6jDh5ilS8YSoaiqYVeMUc7gACEQAD1XH9MTzfOn5i3L0MKwQ"),
            entry("r_1","WJjlzH8Wx58uhgfBeIa0rACMmG1WgACEgAD1XH9MddC5zWtm93FKwQ"),
            entry("y_1","WRjlzH9vR9mvFRbVCOhQpHlWAJdxgACEwAD1XH9McCGkMq9y8TGKwQ"),
            entry("b_2","WZjlzH_CQNT2SR-Ba7FrlptwQppmwACFAAD1XH9Mf9j6jArg8F9KwQ"),
            entry("g_2","WhjlzIAASOfzleDv-ELB85bsdohIyYAAhUAA9Vx_TEmQVocCddOlisE"),
            entry("r_2","WpjlzICRYeoKxAe2X7N_59U4qhHcAACFgAD1XH9MSsmKX02ghx9KwQ"),
            entry("y_2","WxjlzID5mL-9r3lGObuOgYbFeTpJQACFwAD1XH9MfGFOYTRiw81KwQ"),
            entry("b_3","W5jlzIFPhjMp6q81msyExoh0kXPpgACGAAD1XH9MVC_bHupfFX8KwQ"),
            entry("g_3","XBjlzIHMt9x5B15w-LQCWGvXMMvKwACGQAD1XH9MfQQa4Wrf2NJKwQ"),
            entry("r_3","XJjlzINYEx6HjKc-TCpGqBkMG5L3gACGgAD1XH9Ma5Fbu8WPhBtKwQ"),
            entry("y_3","XRjlzIW7NI3d7SLBTEx-VidYL4ghgACGwAD1XH9MVfnVtaRIqAJKwQ"),
            entry("b_4","XZjlzIX7qok2S-YNY7Ber7RSdoI5QACHAAD1XH9MSA9J0xzJNaWKwQ"),
            entry("g_4","XhjlzIYjB6Oey2RuCmXsQbYpL9zsQACHQAD1XH9Me5qB5xJOcexKwQ"),
            entry("r_4","XpjlzIZYgh6H_J7RmcPPswpoOWwgQACHgAD1XH9MdZvARVExLVWKwQ"),
            entry("y_4","XxjlzIbtH_jD4Z61cidyHlnX3Kn2wACHwAD1XH9Mc2usGd8yekwKwQ"),
            entry("b_5","X5jlzIdnrR_gCiV9nBbm96QDfElIAACIAAD1XH9MT897o8pEc-PKwQ"),
            entry("g_5","YBjlzIeeTxrVzo6I4P6N_hBxDyULgACIQAD1XH9MWaf-Udr6254KwQ"),
            entry("r_5","YJjlzIhW5S8xA0vepZDYTR-Ja3FvAACIgAD1XH9MY6anW3L7o1EKwQ"),
            entry("y_5","YRjlzIiyKURXkezq6D3cGz3rqYE7QACIwAD1XH9MTHMTwOgx2x7KwQ"),
            entry("b_6","YZjlzIklFHRtdf9RH2644Ij-2O56AACJAAD1XH9MVj3loMtpOr7KwQ"),
            entry("g_6","YhjlzIl4F6k78RJDPiuYake9wm1bgACJQAD1XH9MTKmfeGmJsNsKwQ"),
            entry("r_6","YpjlzIndbLAGx1ZFtSeIj28OYlYgwACJgAD1XH9MUFIAAG0tcxH0ysE"),
            entry("y_6","YxjlzIomCuVohZdtx3ncj5oRqvD1wACJwAD1XH9MWFfEUW5kLrbKwQ"),
            entry("b_7","Y5jlzIpEeUh2arF8zi7TBkB6_dbagACKAAD1XH9MYEdv4Otaic7KwQ"),
            entry("g_7","ZBjlzIrz4pX2VN6Q2txcKsvn7D9fQACKQAD1XH9MTqEp36SYdZ2KwQ"),
            entry("r_7","ZJjlzIsvOeReE_Fo-neDxITxfA8dAACKgAD1XH9MQmh8w4HWwrwKwQ"),
            entry("y_7","ZRjlzIurfoMnD-1aS_dDWpMeW9h3QACKwAD1XH9MYdOCtIvb78ZKwQ"),
            entry("b_8","ZZjlzIw2Jmyx8pwDbijP_v7pmEKhAACLAAD1XH9MeahQ-8HngpKKwQ"),
            entry("g_8","ZhjlzIxpoL87-NiMM_TLX6sUcrJEwACLQAD1XH9MQNOwvHmRadcKwQ"),
            entry("r_8","ZpjlzIzUb4nhZQAATRP7QUcaEVScM8AAi4AA9Vx_TGvlOWJabFUuisE"),
            entry("y_8","ZxjlzI0O0w2XncE63LT4sr3b5fOiQACLwAD1XH9MbaVD19v0GWDKwQ"),
            entry("b_9","Z5jlzI2xseZTtVvQL-kKPI-BwbwQQACMAAD1XH9MTdqAUi_ihZ2KwQ"),
            entry("g_9","aBjlzI4OcOflNW44tJ5q-41v8gKgAACMQAD1XH9MYz48Kx-497aKwQ"),
            entry("r_9","aJjlzI5Ny6SvmbB52WXokKBy-ZANwACMgAD1XH9MUeArT3AREsZKwQ"),
            entry("y_9","aRjlzI7rG-zPgABiyqtnJr39Rr3eL4AAjMAA9Vx_THLe6BOwBg4JysE"),
            entry("b_draw_2","aZjlzI8I2lBCqoQ2FEGwHQ94LFw1wACNAAD1XH9MfvlnFXOQy1_KwQ"),
            entry("g_draw_2","ahjlzI-xv8Q22ljsuZcUj4ZGzWLgACNQAD1XH9MXMF1HtRA3wLKwQ"),
            entry("r_draw_2", "apjlzJAvUWi5C0NW-gJX2PMJNkzAgACNgAD1XH9Mf0nXgS0jZUjKwQ"),
            entry("y_draw_2","axjlzJCIpfhpIEpYh_qMXLEkmwgrQACNwAD1XH9MbS15OZyhmozKwQ")
    );

    public static String getFromFormatString(String formatString){
        return Instance.stickersPrefix + Instance.data.get(formatString);
    }
}
