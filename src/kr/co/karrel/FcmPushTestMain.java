package kr.co.karrel;

public class FcmPushTestMain {

	public static void main(String[] args) {
		String token = "e1eHmB8tOFA:APA91bGg5rqYV1jS_PgCeoCZFGwdIyZeAuwFWfq-AxsldpoO8aLllftj13ISk2ZRlW6gOxmz38hr9O7aRnUxg5a4v3Z-TQ1uPVt78Zg-ncF41unlZKYhl19OLueBxxha04nqLklXkT3v";
		try {
			FcmPushTest.pushFCMNotification(token, "hello");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
