package com.alephdatasolutons.app.telegram.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class AlephBotService extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		String mensajeRecibido = update.getMessage().getText();
		System.out.println("Alguien envio un msj al bot: "+mensajeRecibido);
		final long chatId = update.getMessage().getChatId();
		
		SendMessage mensajeAEnviar = new SendMessage();
		mensajeAEnviar.setChatId(chatId);
		
		String mensaje = "Gracias por escribirnos, Aleph bot estoy en aprendizaje";
		mensajeAEnviar.setText(mensaje);
		
		try {
			execute(mensajeAEnviar);
		}catch(TelegramApiException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getBotUsername() {

		return "alephtest_bot";
	}
	
	@Override
	public String getBotToken() {
		return "6172389952:AAFbkpALAMgsqjfAGHbUoqkE4K5-Wkfz-XM";
	}
	
}
