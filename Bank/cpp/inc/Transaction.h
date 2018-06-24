#ifndef TRANSACTION_H_
#define TRANSACTION_H_

#include <string>

class Transaction
{
public:
        Transaction(const std::string& date, const int amount);
        const std::string date() const;
        const int amount() const;
        const bool operator==(const Transaction& rhs) const;
private:
        std::string m_date;
        int m_amount;
};


#endif
