/* * To change this template, choose Tools | Templates * and open the template in the editor. */package business;import deliver.Deliver;import java.util.ArrayList;/** * * @author Fernando */// Alex guapo :Dpublic class Tablas {    public static void createTable(String tableName, ArrayList<String> matches,             ArrayList<String> names, ArrayList<String> types) {        String phrase = "{ " + tableName;        for (int i = 0; i < names.size(); i++) {            phrase += " " + matches.get(i) + "." + names.get(i)                     + "." + types.get(i);        }        phrase += " }";        // TODO: Arreglar el número.        Deliver.deliver(1, phrase);    }}