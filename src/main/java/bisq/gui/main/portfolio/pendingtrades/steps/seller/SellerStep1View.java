/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.gui.main.portfolio.pendingtrades.steps.seller;

import bisq.common.locale.Res;



import bisq.gui.main.portfolio.pendingtrades.PendingTradesViewModel;
import bisq.gui.main.portfolio.pendingtrades.steps.TradeStepView;

public class SellerStep1View extends TradeStepView {

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Constructor, Initialisation
    ///////////////////////////////////////////////////////////////////////////////////////////

    public SellerStep1View(PendingTradesViewModel model) {
        super(model);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Info
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected String getInfoBlockTitle() {
        return Res.get("portfolio.pending.step1.waitForConf");
    }

    @Override
    protected String getInfoText() {
        return Res.get("portfolio.pending.step1.info", Res.get("shared.TheBTCBuyer"));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Warning
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected String getWarningText() {
        setWarningHeadline();
        return Res.get("portfolio.pending.step1.warn");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Dispute
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected String getOpenForDisputeText() {
        return Res.get("portfolio.pending.step1.openForDispute");
    }
}

