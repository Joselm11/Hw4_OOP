

import java.util.ArrayList;
/**
 * Auction class handles the bidding system with multiple lots.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Auction {
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    /**
     * Constructor for objects of class Auction
     */
    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Adds a new lot to the auction.
     *
     * @param description Description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Displays all lots in the auction.
     */
    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot);
        }
    }

    /**
     * Places a bid on a lot.
     *
     * @param lotNumber The lot number to bid on.
     * @param bidder    The person placing the bid.
     * @param value     The bid value.
     */
    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            if (selectedLot.bidFor(new Bid(bidder, value))) {
                System.out.println("The bid for lot number: " + lotNumber + " was successful");
            } else {
                System.out.println("Lot number: " + lotNumber + " already has a higher bid.");
            }
        }
    }

    /**
     * Retrieves a lot by its number.
     *
     * @param lotNumber The lot number.
     * @return The corresponding Lot object or null if not found.
     */
    public Lot getLot(int lotNumber) {
        if ((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            Lot selectedLot = lots.get(lotNumber - 1);
            if (selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal lot.get error: Lot number " +
                        selectedLot.getNumber() + " was returned instead of " + lotNumber);
                return null;
            }
            return selectedLot;
        } else {
            System.out.println("Lot number " + lotNumber + " does not exist");
            return null;
        }
    }

    /**
     * Closes the auction and prints the results.
     */
    public void close() {
        for (Lot lot : lots) {
            Bid highestBid = lot.getHighestBid();
            if (highestBid != null) {
                System.out.println("Lot " + lot.getNumber() + " was sold to " +
                        highestBid.getBidder().getName() + " for " + highestBid.getValue());
            } else {
                System.out.println("Lot " + lot.getNumber() + " has not been sold.");
            }
        }
    }
}
