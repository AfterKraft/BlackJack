package com.whitejack.api;

public abstract class Game implements Runnable {
	protected Player players[];

	/**
	 * @deprecated Don't use start() unless you wish to perform a single thread game with a single user.
	 */
	public void start() {
	}

	public void stop() {
	}

	public void play() {
	}

	// THIS IS FOR THE MUL-THREAD OPTION
	public void run() {/* THE CODE HERE IS A THE @OVERRIDE FOR START() METHOD */
	}
}