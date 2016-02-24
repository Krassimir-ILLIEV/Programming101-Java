package com.week13.Helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.week13.basicNoFuncClasses.DeliveryRequest;
import com.week13.basicNoFuncClasses.SupplyRequest;

public class InputReader {

	String[] requests;
	int pointer;

	public InputReader(String path) {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				if (line.indexOf("supply") != 0 && line.indexOf("delivery") != 0)
					continue; // wrong input information
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			requests = sb.toString().split(System.lineSeparator());
			pointer = 0; // points to first unread line; it may also point to
							// last unread (initiate to -1)
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getNextRequestType() {
		if (pointer == requests.length)
			return null; // no more requests

		String currentRequest = requests[pointer].trim();
		if (currentRequest.indexOf("supply") == 0) {
			return "supply";
		} else if (currentRequest.indexOf("delivery") == 0) {
			return "delivery";
		}
		return null; // means input is incorrect
	}

	public SupplyRequest convertToSupplyRequest() {
		String currentRequest = requests[pointer].trim();
		pointer++;
		return new SupplyRequest(currentRequest);
	}

	public DeliveryRequest convertToDeliveryRequest() {
		String currentRequest = requests[pointer].trim();
		pointer++;
		return new DeliveryRequest(currentRequest);
	}

	public void readFile____(String path) { // previous attempt

		BufferedReader br;
		try {
			FileReader fr = new FileReader(path);
			br = new BufferedReader(fr);
			String x;
			while ((x = br.readLine()) != null) {
				System.out.println(x);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// inputReader parser = new inputReader();
		// String
		// document=parser.readFile("/home/ubuntu/workspace/Week13Monday_2202/src/testDeliveryRequests");
		// System.out.println(document);
		// String[] documentArray=document.split(System.lineSeparator());

		// SupplyRequest sr=new SupplyRequest(documentArray[1]);
		// System.out.println(sr);

	}
}