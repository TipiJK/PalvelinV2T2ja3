package com.example.viikko2lista.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.viikko2lista.domain.Friend;
import com.example.viikko2lista.domain.Student;

@Controller
public class Viikko2listaController {
		ArrayList<Friend> kaverit = new ArrayList<>();

		@GetMapping("/hello")
		public String students(Model model) {

			ArrayList<Student> opiskelijat = new ArrayList<>();
			opiskelijat.add(new Student("Alma","Aapinen"));
			opiskelijat.add(new Student("Bertta","Berg"));
			opiskelijat.add(new Student("Carl","Carlsson"));
			
			model.addAttribute("studentsList", opiskelijat);
			
			return "studentlist";
	}
		@GetMapping("/index")
		public String friends(@RequestParam (name="name", required=false) String name, Model model) {
		//public String friends(Model model) {

			kaverit.add(new Friend(name));
			
			model.addAttribute("friendList", kaverit);
			
			return "friends";
	}
}
