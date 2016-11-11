package sort.other;

public class HtmlOperate {
	public static void main(String[] args) {
		String goldCoinStoreUrl = "jfoawiejif.html?version=j&token=fawe";
		goldCoinStoreUrl += goldCoinStoreUrl.contains("?") ? "" : "?";
        goldCoinStoreUrl += goldCoinStoreUrl.contains("=") ? "&" : "";
        goldCoinStoreUrl += "token=" + "token00";
        System.out.println(goldCoinStoreUrl);
	}
}
