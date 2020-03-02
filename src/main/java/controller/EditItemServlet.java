package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DateOfLastOilChange;
import model.ListItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ListItemHelper dao = new ListItemHelper();
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setMake(make);
		itemToUpdate.setModel(model);
		itemToUpdate.setYear(year);
		dao.updateItem(itemToUpdate);
		
		DateOfLastOilChangeHelper oilChangeDateHelper = new DateOfLastOilChangeHelper();
		
		// update the date
		String serviceMonth = request.getParameter("serviceMonth");
		String serviceDay = request.getParameter("serviceDay");
		String serviceYear = request.getParameter("serviceYear");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(serviceYear), Integer.parseInt(serviceMonth), Integer.parseInt(serviceDay));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		DateOfLastOilChange oilChangeDateToUpdate = oilChangeDateHelper.searchForItemById(tempId);
		if (oilChangeDateToUpdate != null) {
			oilChangeDateToUpdate.setServiceDate(ld);
			oilChangeDateHelper.updateItem(oilChangeDateToUpdate);
		} else {
			DateOfLastOilChange oilChangeDate = new DateOfLastOilChange();
			oilChangeDate.setId(tempId);
			oilChangeDate.setServiceDate(ld);
			oilChangeDateHelper.insertDate(oilChangeDate, tempId);
		}
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
